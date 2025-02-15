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
package io.seata.saga.rm;

import io.seata.core.model.BranchType;
import io.seata.core.model.Resource;

/**
 * Saga resource (Only register application as a saga resource)
 *
 */
public class SagaResource implements Resource {

    private String resourceGroupId;

    private String applicationId;

    /**
     * Gets get resource group id.
     *
     * @return the get resource group id
     */
    @Override
    public String getResourceGroupId() {
        return resourceGroupId;
    }

    /**
     * Sets set resource group id.
     *
     * @param resourceGroupId the resource group id
     */
    public void setResourceGroupId(String resourceGroupId) {
        this.resourceGroupId = resourceGroupId;
    }

    /**
     * Gets get resource id.
     *
     * @return the get resource id
     */
    @Override
    public String getResourceId() {
        return applicationId + "#" + resourceGroupId;
    }

    /**
     * Gets get branch type.
     *
     * @return the get branch type
     */
    @Override
    public BranchType getBranchType() {
        return BranchType.SAGA;
    }

    /**
     * Gets get application id.
     *
     * @return the get application id
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Sets set application id.
     *
     * @param applicationId the application id
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}
