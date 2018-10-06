/**
 * 
 */
package com.earlybird.wms.base.repository;

import org.springframework.stereotype.Repository;

import com.earlybird.wms.base.entity.OrderLine;

/**
 * @author Peili Zhou
 *
 */
@Repository
public interface OrderLineRepository extends BaseRepository<OrderLine, Long> {

}
