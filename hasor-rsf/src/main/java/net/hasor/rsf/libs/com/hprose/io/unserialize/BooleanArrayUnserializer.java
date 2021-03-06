/**********************************************************\
 |                                                          |
 |                          hprose                          |
 |                                                          |
 | Official WebSite: http://www.hprose.com/                 |
 |                   http://www.hprose.org/                 |
 |                                                          |
 \**********************************************************/
/**********************************************************\
 *                                                        *
 * BooleanArrayUnserializer.java                          *
 *                                                        *
 * boolean array unserializer class for Java.             *
 *                                                        *
 * LastModified: Aug 3, 2016                              *
 * Author: Ma Bingyao <andot@hprose.com>                  *
 *                                                        *
 \**********************************************************/
package net.hasor.rsf.libs.com.hprose.io.unserialize;
import java.io.IOException;
import java.lang.reflect.Type;

import static net.hasor.rsf.libs.com.hprose.io.HproseTags.TagEmpty;
import static net.hasor.rsf.libs.com.hprose.io.HproseTags.TagList;
public final class BooleanArrayUnserializer extends BaseUnserializer<boolean[]> {
    public final static BooleanArrayUnserializer instance = new BooleanArrayUnserializer();
    @Override
    public boolean[] unserialize(Reader reader, int tag, Type type) throws IOException {
        if (tag == TagList)
            return ReferenceReader.readBooleanArray(reader);
        if (tag == TagEmpty)
            return new boolean[0];
        return super.unserialize(reader, tag, type);
    }
    public boolean[] read(Reader reader) throws IOException {
        return read(reader, boolean[].class);
    }
}
