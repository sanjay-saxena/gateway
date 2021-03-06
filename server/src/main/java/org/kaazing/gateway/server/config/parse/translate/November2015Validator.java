/**
 * Copyright 2007-2016, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.gateway.server.config.parse.translate;

import org.kaazing.gateway.server.config.parse.translate.sep2014.AcceptUriComparedToBalanceUriVisitor;
import org.kaazing.gateway.server.config.parse.translate.sep2014.FindMatchingBalancerServiceVisitor;

public class November2015Validator extends GatewayConfigTranslatorPipeline {
    public November2015Validator() {
        super();

        // compare accept URIs to balance URIs within a service, ensure they differ by hostname only
        addTranslator(new AcceptUriComparedToBalanceUriVisitor());

        // for each balance URI, make sure there is a corresponding balancer service accepting on that URI
        // for each balancer service accept URI, make sure there is a corresponding balance URI pointing to that service
        addTranslator(new FindMatchingBalancerServiceVisitor());
    }
}
