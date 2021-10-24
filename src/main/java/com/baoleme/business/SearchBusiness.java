package com.baoleme.business;

import com.baoleme.dao.MerchantDao;
import com.baoleme.pojo.Merchant;
import com.baoleme.pojo.MerchantGraph;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchBusiness {

    @Autowired
    private CategoryBusiness categoryBusiness;

    @Autowired
    private MerchantDao merchantDao;

    public List<Merchant> search(String content) {
        try {
            List<Merchant> merchants = getMerchant(content);

            // 如果还是没有，分词后检索
            if(CollectionUtils.isEmpty(merchants)) {
                List<String> words = getWord(content);
                for (String word: words) {
                    if (CollectionUtils.isEmpty(merchants)) {
                        merchants = getMerchant(word);
                    }
                }
            }

            return merchants;
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    private List<Merchant> getMerchant(String content) {
        //首先去图数据库检索类别
        List<MerchantGraph> merchantGraphs = categoryBusiness.getMerchantByCategory(content);

        List<Merchant> merchants;
        //如果没有类别，则从mysql中检索特定的商品
        if(CollectionUtils.isEmpty(merchantGraphs)){
            String merchantName = content;
            merchants = merchantDao.getAllByName(merchantName);
        } else {
            List<Long> merchantIds = merchantGraphs.stream().map(MerchantGraph::getMysqlId).collect(Collectors.toList());
            merchants = merchantDao.getAllByIds(merchantIds);
        }
        return merchants;
    }

    private List<String> getWord(String content) throws Exception {
        List<String> words = new ArrayList<>();
        // 分词
        Analyzer analyzer = new IKAnalyzer(true);

        // 获取Lucene的TokenStream对象
        TokenStream ts = analyzer.tokenStream("word",new StringReader(content));
        // 获取词元位置属性
        OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
        // 获取词元文本属性
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        // 获取词元文本属性
        TypeAttribute type = ts.addAttribute(TypeAttribute.class);

        // 重置TokenStream（重置StringReader）
        ts.reset();
        // 迭代获取分词结果
        while (ts.incrementToken()) {
            if (type.type().equals("CN_WORD")) {
                words.add(term.toString());
            }
        }
        // 关闭TokenStream（关闭StringReader）
        ts.end(); // Perform end-of-stream operations, e.g. set the final offset.

        // 释放TokenStream的所有资源
        ts.close();
        analyzer.close();

        return words;
    }

}
