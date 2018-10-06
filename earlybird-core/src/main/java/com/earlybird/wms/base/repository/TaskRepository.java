/**
 * 
 */
package com.earlybird.wms.base.repository;

import org.springframework.stereotype.Repository;

import com.earlybird.wms.base.entity.Task;

/**
 * @author Peili Zhou
 *
 */
@Repository
public interface TaskRepository extends BaseRepository<Task, Long> {

}
