/*
 * Copyright (c) 2008 - 2012 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 */
package com.google.code.morphia.converters;

import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;
import org.bson.types.ObjectId;

/**
 * Convert to an ObjectId from string
 *
 * @author scotthernandez
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class ObjectIdConverter extends TypeConverter implements SimpleValueConverter {

    public ObjectIdConverter() {
        super(ObjectId.class);
    }

    @Override
    public Object decode(final Class targetClass, final Object val, final MappedField optionalExtraInfo) throws
            MappingException {
        if (val == null) {
            return null;
        }

        if (val instanceof ObjectId) {
            return val;
        }

        return new ObjectId(val.toString()); // good luck
    }
}
