/**
 * 
 */
package com.earlybird.wms.base.repository;

import org.springframework.stereotype.Repository;

import com.earlybird.wms.base.entity.Order;

/**
 * @author Peili Zhou
 *
 */
@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {

}
