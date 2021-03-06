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

import java.io.InputStream;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;

/**
 * Json envelope.
 *
 * @author Vseslav Sekorin (vssekorin@gmail.com)
 * @version $Id$
 * @since 0.1
 * @checkstyle AbstractClassNameCheck (500 lines)
 */
@SuppressWarnings("PMD.AbstractNaming")
public abstract class JsonEnvelope implements Json {

    /**
     * The Json.
     */
    private final UncheckedScalar<Json> origin;

    /**
     * Ctor.
     * @param json The source
     */
    public JsonEnvelope(final Scalar<Json> json) {
        this.origin = new UncheckedScalar<>(json);
    }

    @Override
    public final InputStream stream() throws Exception {
        return this.origin.value().stream();
    }
}
