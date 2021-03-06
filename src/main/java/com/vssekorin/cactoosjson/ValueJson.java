/**
 * MIT License
 *
 * Copyright (c) 2018 Vseslav Sekorin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.vssekorin.cactoosjson;

import org.cactoos.Bytes;
import org.cactoos.Func;
import org.cactoos.Scalar;
import org.cactoos.Text;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;

/**
 * Json for value of field.
 *
 * @author Vseslav Sekorin (vssekorin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class ValueJson extends JsonEnvelope {

    /**
     * Class pattern matching.
     */
    @SuppressWarnings("unchecked")
    private static final Func<Object, Json> CPM = new ClassPatternMatching<>(
        new MapOf<>(
            new MapEntry<>(String.class, StringJson::new),
            new MapEntry<>(Text.class, TextJson::new),
            new MapEntry<>(Integer.class, IntegerJson::new),
            new MapEntry<>(Long.class, LongJson::new),
            new MapEntry<>(Scalar.class, ScalarJson::new),
            new MapEntry<>(Iterable.class, IterableJson::new),
            new MapEntry<>(Bytes.class, BytesJson::new)
        ),
        val -> new AllFields(val, "    ")
    );

    /**
     * Ctor.
     * @param value Value of field
     */
    public ValueJson(final Object value) {
        super(() -> ValueJson.CPM.apply(value));
    }
}
