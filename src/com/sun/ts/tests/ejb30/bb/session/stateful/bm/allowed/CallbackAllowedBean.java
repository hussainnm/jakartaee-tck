/*
 * Copyright (c) 2007, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id$
 */

package com.sun.ts.tests.ejb30.bb.session.stateful.bm.allowed;

import java.util.Properties;

import com.sun.ts.tests.ejb30.common.allowed.CallbackAllowedBeanBase;
import com.sun.ts.tests.ejb30.common.allowed.CallbackAllowedIF;
import com.sun.ts.tests.ejb30.common.allowed.CallbackAllowedLocalIF;
import com.sun.ts.tests.ejb30.common.allowed.stateful.TimerLocalIF;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import jakarta.ejb.Remove;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateful;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.interceptor.Interceptors;

@Stateful(name = "CallbackAllowedBean")
@Remote({ CallbackAllowedIF.class })
@Local({ CallbackAllowedLocalIF.class })
@TransactionManagement(TransactionManagementType.BEAN)
@Interceptors({
    com.sun.ts.tests.ejb30.common.allowed.stateful.StatefulCancelInterceptor.class })

@EJB(name = "ejb/TimerEJB", beanName = "TimerEJB", beanInterface = TimerLocalIF.class)
public class CallbackAllowedBean extends CallbackAllowedBeanBase
    implements CallbackAllowedIF, CallbackAllowedLocalIF, java.io.Serializable {

  @PostConstruct
  public void ejbCreate() {
    super.ejbCreate();
  }

  @Resource(name = "ejbContext")
  public void setSessionContext(SessionContext sc) {
    super.setSessionContext(sc);
  }

  @Remove
  public void remove() {
    super.remove();
  }

  @Override
  public Properties runOperations(SessionContext sctx) {
    return StatefulBMTOperations.getInstance().run2(sctx,
        CallbackAllowedIF.class);
  }

}
