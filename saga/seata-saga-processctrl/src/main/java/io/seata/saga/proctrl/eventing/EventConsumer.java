/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.seata.saga.proctrl.eventing;

import io.seata.common.exception.FrameworkException;

/**
 * Event Consumer
 *
 */
public interface EventConsumer<E> {

    /**
     * process
     *
     * @param event the event
     * @throws FrameworkException the framework exception
     */
    void process(E event) throws FrameworkException;

    /**
     * if thd handler can handle this class return true otherwise return false
     *
     * @param clazz the event class
     * @return the boolean
     */
    boolean accept(Class<E> clazz);
}
