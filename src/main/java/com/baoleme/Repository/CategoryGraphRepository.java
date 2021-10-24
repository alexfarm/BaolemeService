package com.baoleme.Repository;

import com.baoleme.pojo.CategoryGraph;
import com.baoleme.pojo.MerchantGraph;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface CategoryGraphRepository extends Neo4jRepository<CategoryGraph,Long> {

    @Query("MATCH (t:CategoryGraph{name:{0}}) -- (merchant: MerchantGraph) RETURN merchant")
    List<MerchantGraph> getMerchantsByCategory(@Param("category") String category);
}
