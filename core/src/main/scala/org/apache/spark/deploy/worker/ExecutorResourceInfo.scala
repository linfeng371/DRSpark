/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.deploy.worker

import org.apache.spark.internal.Logging

private[spark] class ExecutorResourceInfo with Logging(
    _executorId: String,
    _cpuRate: Float,
    _memRate: Float)
  extends Serializable {
    val executorId = _executorId
    val cpuRate = _cpuRate
    val memRate = _memRate
    override def equals(other: Any): Boolean = other match {  
      case that:Ei =>       	
      	if(this.executorId == that.executorId){
      		logInfo(s"Warning! Duplicate ExecutorResourceInfo appears,id=${that.executorId}") 
      		true
      	}
      	else false
      case _ => false 
  }   
}