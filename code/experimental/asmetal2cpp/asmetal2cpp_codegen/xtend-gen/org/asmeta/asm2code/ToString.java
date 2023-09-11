package org.asmeta.asm2code;

import asmeta.definitions.domains.AbstractTd;
import asmeta.definitions.domains.AnyDomain;
import asmeta.definitions.domains.BooleanDomain;
import asmeta.definitions.domains.ConcreteDomain;
import asmeta.definitions.domains.EnumElement;
import asmeta.definitions.domains.EnumTd;
import asmeta.definitions.domains.IntegerDomain;
import asmeta.definitions.domains.NaturalDomain;
import asmeta.definitions.domains.PowersetDomain;
import asmeta.definitions.domains.RealDomain;
import asmeta.definitions.domains.SequenceDomain;
import asmeta.definitions.domains.StringDomain;
import asmeta.structure.Asm;
import org.asmeta.parser.util.ReflectiveVisitor;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ToString extends ReflectiveVisitor<String> {
  Integer numStaticParam;
  
  private Asm res;
  
  private boolean leftHandSide;
  
  private boolean seqBlock;
  
  private boolean pointer;
  
  public ToString(final Asm resource) {
    this(resource, false, false);
  }
  
  public ToString(final Asm resource, final boolean leftHandSide, final boolean seqBlock) {
    this.res = resource;
    this.leftHandSide = leftHandSide;
    this.seqBlock = seqBlock;
    this.pointer = false;
  }
  
  public ToString(final Asm asm, final boolean pointer) {
    this.res = asm;
    this.pointer = pointer;
  }
  
  public String visit(final StringDomain domain) {
    return "string";
  }
  
  public String visit(final BooleanDomain domain) {
    return "bool";
  }
  
  public String visit(final IntegerDomain domain) {
    return "int";
  }
  
  public String visit(final NaturalDomain domain) {
    return "unsigned int";
  }
  
  public String visit(final AnyDomain object) {
    return "ANY";
  }
  
  public String visit(final RealDomain object) {
    return "double";
  }
  
  public String visit(final PowersetDomain object) {
    StringBuffer sb = new StringBuffer();
    StringConcatenation _builder = new StringConcatenation();
    String _visit = new DomainToH(this.res).visit(object);
    _builder.append(_visit);
    sb.append(_builder);
    return sb.toString();
  }
  
  public String visit(final SequenceDomain object) {
    StringBuffer sb = new StringBuffer();
    StringConcatenation _builder = new StringConcatenation();
    String _visit = new DomainToH(this.res).visit(object);
    _builder.append(_visit);
    sb.append(_builder);
    return sb.toString();
  }
  
  public String visit(final AbstractTd object) {
    StringBuffer sb = new StringBuffer();
    StringConcatenation _builder = new StringConcatenation();
    String _visit = new DomainToH(this.res, this.pointer).visit(object);
    _builder.append(_visit);
    sb.append(_builder);
    return sb.toString();
  }
  
  public String visit(final ConcreteDomain domain) {
    return domain.getName();
  }
  
  public String visit(final EnumElement elem) {
    return elem.getSymbol();
  }
  
  public String visit(final EnumTd elem) {
    return elem.getName();
  }
}
