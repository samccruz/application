/*
 * Copyright 2016 International Systems Research Co. (ISR).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.co.isr.application.account.repository;

import java.util.Date;
import java.util.stream.Stream;
import jp.co.isr.application.account.model.entity.AccountLoginAudit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * This is the {@link org.springframework.data.repository.Repository} for
 * {@link AccountLoginAudit}.
 *
 * @author Warren Nocos
 * @since 1.0
 * @version 1.0
 */
@Repository
public interface AccountLoginAuditRepository
        extends JpaRepository<AccountLoginAudit, Long> {

    @Query("SELECT DISTINCT a.loginTime FROM AccountLoginAudit a ORDER BY a.loginTime ASC")
    Stream<Date> findAllLoginDate();

    @Query("SELECT DISTINCT a.loginTime FROM AccountLoginAudit a")
    Stream<Date> findAllLoginDate(Pageable pageable);

}
