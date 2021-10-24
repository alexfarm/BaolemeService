package com.baoleme.Repository;

import com.baoleme.pojo.CategoryGraph;
import com.baoleme.pojo.MerchantGraph;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface CategoryGraphRepository extends Neo4jRepository<CategoryGraph,Long> {

    @Query("MATCH (n:CategoryGraph)--(merchant:MerchantGraph) where n.name contains {0}" +
            " return merchant")
    List<MerchantGraph> getMerchantsByCategory(@Param("category")String category);
}
