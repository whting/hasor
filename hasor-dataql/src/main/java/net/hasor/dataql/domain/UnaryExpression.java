/*
 * Copyright 2008-2009 the original author or authors.
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
package net.hasor.dataql.domain;
import net.hasor.dataql.domain.compiler.CompilerStack;
import net.hasor.dataql.domain.compiler.InstQueue;
import net.hasor.dataql.domain.compiler.Opcodes;
/**
 * 一元运算表达式
 * @author 赵永春(zyc@hasor.net)
 * @version : 2017-03-23
 */
public class UnaryExpression extends Expression {
    private Expression target;      //表达式
    private String     dyadicSymbol;//操作符
    public UnaryExpression(Expression target, String dyadicSymbol) {
        super();
        this.target = target;
        this.dyadicSymbol = dyadicSymbol;
    }
    //
    @Override
    public void doCompiler(InstQueue queue, CompilerStack stackTree) {
        this.target.doCompiler(queue, stackTree);
        queue.inst(Opcodes.UO, this.dyadicSymbol);
    }
}