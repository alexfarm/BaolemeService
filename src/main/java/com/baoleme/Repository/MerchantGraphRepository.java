package com.baoleme.Repository;

import com.baoleme.pojo.MerchantGraph;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MerchantGraphRepository extends Neo4jRepository<MerchantGraph,Long> {

    MerchantGraph findByName(String name);

}
