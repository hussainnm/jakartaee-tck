<%--

    Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.

    This program and the accompanying materials are made available under the
    terms of the Eclipse Public License v. 2.0, which is available at
    http://www.eclipse.org/legal/epl-2.0.

    This Source Code may also be made available under the following Secondary
    Licenses when the conditions for such availability set forth in the
    Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
    version 2 with the GNU Classpath Exception, which is available at
    https://www.gnu.org/software/classpath/license.html.

    SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0

--%>

<% /** 	Name : IsELIgnoredFalseTemplateTextPoundTest
	Description : Verify that EL expressions are recognized by the
                      container in template text when the isELIgnored 
                      attribute is set to false and the '#' character is 
                      used. Since the use of the '#' character is illegal
                      in template text, a translation error should be 
                      generated.
**/ %>	 
<%@ page isELIgnored="false" %>

<%
    pageContext.setAttribute("pexp", "pound", PageContext.PAGE_SCOPE);
 %>

begin
    #{pexp}
end
