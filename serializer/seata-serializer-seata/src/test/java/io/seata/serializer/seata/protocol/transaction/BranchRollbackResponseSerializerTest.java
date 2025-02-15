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
package io.seata.serializer.seata.protocol.transaction;

import io.seata.serializer.seata.SeataSerializer;
import io.seata.core.exception.TransactionExceptionCode;
import io.seata.core.model.BranchStatus;
import io.seata.core.protocol.ResultCode;
import io.seata.core.protocol.transaction.BranchRollbackResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Branch rollback response codec test.
 *
 */
public class BranchRollbackResponseSerializerTest {

    /**
     * The Seata codec.
     */
    SeataSerializer seataSerializer = new SeataSerializer();

    /**
     * Test codec.
     */
    @Test
    public void test_codec(){
        BranchRollbackResponse branchRollbackResponse = new BranchRollbackResponse();
        branchRollbackResponse.setBranchId(112232);
        branchRollbackResponse.setXid("123");
        branchRollbackResponse.setBranchStatus(BranchStatus.PhaseOne_Done);
        branchRollbackResponse.setResultCode(ResultCode.Success);
        branchRollbackResponse.setMsg("abc");
        branchRollbackResponse.setTransactionExceptionCode(TransactionExceptionCode.BranchTransactionNotExist);

        byte[] bytes = seataSerializer.serialize(branchRollbackResponse);

        BranchRollbackResponse branchRollbackResponse2 = seataSerializer.deserialize(bytes);

        assertThat(branchRollbackResponse2.getBranchId()).isEqualTo(branchRollbackResponse.getBranchId());
        assertThat(branchRollbackResponse2.getBranchStatus()).isEqualTo(branchRollbackResponse.getBranchStatus());
        assertThat(branchRollbackResponse2.getResultCode()).isEqualTo(branchRollbackResponse.getResultCode());
        assertThat(branchRollbackResponse2.getXid()).isEqualTo(branchRollbackResponse.getXid());
        assertThat(branchRollbackResponse2.getBranchStatus()).isEqualTo(branchRollbackResponse.getBranchStatus());
        assertThat(branchRollbackResponse2.getTransactionExceptionCode()).isEqualTo(branchRollbackResponse.getTransactionExceptionCode());

    }
}
