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

import java.io.SequenceInputStream;
import org.cactoos.io.InputStreamOf;

/**
 * Json for field.
 *
 * @author Vseslav Sekorin (vssekorin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class FieldJson extends JsonEnvelope {

    /**
     * Ctor.
     * @param name Field name
     * @param value Field value
     */
    public FieldJson(final String name, final Object value) {
        this(name, value, "");
    }

    /**
     * Ctor.
     * @param name Field name
     * @param value Field value
     * @param indent Indent
     */
    public FieldJson(final String name, final Object value,
        final String indent) {
        super(() -> () -> new SequenceInputStream(
            new InputStreamOf(
                String.format("%s%s%s%s", indent, "    \"", name, "\": ")
            ),
            new ValueJson(value).stream()
        ));
    }
}