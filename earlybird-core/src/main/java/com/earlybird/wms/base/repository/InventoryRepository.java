/**
 * 
 */
package com.earlybird.wms.base.repository;

import org.springframework.stereotype.Repository;

import com.earlybird.wms.base.entity.Inventory;

/**
 * @author Peili Zhou
 *
 */
@Repository
public interface InventoryRepository extends BaseRepository<Inventory, Long> {

}
