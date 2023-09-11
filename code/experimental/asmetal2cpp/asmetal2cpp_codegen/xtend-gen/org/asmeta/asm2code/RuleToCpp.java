package org.asmeta.asm2code;

import asmeta.definitions.domains.AbstractTd;
import asmeta.definitions.domains.Domain;
import asmeta.definitions.domains.PowersetDomain;
import asmeta.definitions.domains.StringDomain;
import asmeta.structure.Asm;
import asmeta.terms.basicterms.Term;
import asmeta.transitionrules.basictransitionrules.BlockRule;
import asmeta.transitionrules.basictransitionrules.ChooseRule;
import asmeta.transitionrules.basictransitionrules.ConditionalRule;
import asmeta.transitionrules.basictransitionrules.ExtendRule;
import asmeta.transitionrules.basictransitionrules.ForallRule;
import asmeta.transitionrules.basictransitionrules.LetRule;
import asmeta.transitionrules.basictransitionrules.MacroCallRule;
import asmeta.transitionrules.basictransitionrules.Rule;
import asmeta.transitionrules.basictransitionrules.SkipRule;
import asmeta.transitionrules.basictransitionrules.TermAsRule;
import asmeta.transitionrules.basictransitionrules.UpdateRule;
import asmeta.transitionrules.derivedtransitionrules.CaseRule;
import asmeta.transitionrules.derivedtransitionrules.IterativeWhileRule;
import asmeta.transitionrules.turbotransitionrules.IterateRule;
import asmeta.transitionrules.turbotransitionrules.SeqRule;
import org.asmeta.asm2code.main.TranslatorOptions;
import org.asmeta.simulator.RuleVisitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class RuleToCpp extends RuleVisitor<String> {
  private Asm res;
  
  private boolean seqBlock;
  
  private TranslatorOptions options;
  
  /**
   * seqBlock iff it is called in a seq rule
   */
  public RuleToCpp(final Asm resource, final boolean seqBlock, final TranslatorOptions options) {
    this.res = resource;
    this.seqBlock = seqBlock;
    this.options = options;
  }
  
  @Override
  public String visit(final BlockRule object) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ //par");
    _builder.newLine();
    _builder.append("\t");
    String _printRules = new RuleToCpp(this.res, false, this.options).printRules(object.getRules());
    _builder.append(_printRules, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}//endpar");
    return _builder.toString();
  }
  
  private String printRules(final EList<Rule> rules) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; (i < rules.size()); i++) {
      sb.append(new RuleToCpp(this.res, this.seqBlock, this.options).visit(rules.get(i)));
    }
    return sb.toString();
  }
  
  @Override
  public String visit(final MacroCallRule object) {
    String methodName = object.getCalledMacro().getName();
    if (this.seqBlock) {
      String _methodName = methodName;
      methodName = (_methodName + "_seq");
    }
    int _size = object.getParameters().size();
    boolean _equals = (_size == 0);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(methodName);
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(methodName);
      _builder_1.append("(");
      String _printListTerm = this.printListTerm(object.getParameters());
      _builder_1.append(_printListTerm);
      _builder_1.append(");");
      _builder_1.newLineIfNotEmpty();
      return _builder_1.toString();
    }
  }
  
  private String printListTerm(final EList<Term> term) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; (i < term.size()); i++) {
      StringConcatenation _builder = new StringConcatenation();
      String _visit = new TermToCpp(this.res).visit(term.get(i));
      _builder.append(_visit);
      _builder.append(", ");
      sb.append(_builder);
    }
    int _length = sb.length();
    int _minus = (_length - 2);
    return sb.substring(0, _minus);
  }
  
  /**
   * if (singleParam.get(i).id !== null)
   * 	throw new RuntimeException("IdDomain null in rule definition not allowed")
   * if (singleParam.get(i).domain !== null)
   *  throw new RuntimeException("Domain null in rule definition not allowed")
   * }
   * return paramDef.substring(0, paramDef.length - 2) + ")"
   * }
   */
  @Override
  public String visit(final SeqRule object) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{//seq");
    _builder.newLine();
    _builder.append("\t");
    String _printRules = new RuleToCpp(this.res, true, this.options).printRules(object.getRules());
    _builder.append(_printRules, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}//endseq");
    _builder.newLine();
    return _builder.toString();
  }
  
  /**
   * override String visit(SeqNext object) {
   * 		return '''
   * 			{//seqnext
   * 				�new RuleDefinitionIno(res,true).printRules(object.rules)�
   * 			}//endseqnext
   * 		'''
   * }
   */
  @Override
  public String visit(final UpdateRule object) {
    StringBuffer result = new StringBuffer();
    StringConcatenation _builder = new StringConcatenation();
    String _visit = new TermToCpp(this.res, true).visit(object.getLocation());
    _builder.append(_visit);
    _builder.append(" = ");
    String _visit_1 = new TermToCpp(this.res, false).visit(object.getUpdatingTerm());
    _builder.append(_visit_1);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    result.append(_builder);
    if (this.seqBlock) {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _visit_2 = new TermToCpp(this.res, false).visit(object.getLocation());
      _builder_1.append(_visit_2);
      _builder_1.append(" = ");
      String _visit_3 = new TermToCpp(this.res, true).visit(object.getLocation());
      _builder_1.append(_visit_3);
      _builder_1.append(";");
      result.append(_builder_1);
    }
    return result.toString();
  }
  
  @Override
  public String visit(final SkipRule object) {
    return "; \n";
  }
  
  @Override
  public String visit(final CaseRule object) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; (i < object.getCaseBranches().size()); i++) {
      if ((i == 0)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("if(");
        String _compareTerms = this.compareTerms(object.getTerm(), object.getCaseTerm().get(i));
        _builder.append(_compareTerms);
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _visit = new RuleToCpp(this.res, this.seqBlock, this.options).visit(object.getCaseBranches().get(i));
        _builder.append(_visit, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        sb.append(_builder);
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("else if(");
        String _compareTerms_1 = this.compareTerms(object.getTerm(), object.getCaseTerm().get(i));
        _builder_1.append(_compareTerms_1);
        _builder_1.append("){");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        String _visit_1 = new RuleToCpp(this.res, this.seqBlock, this.options).visit(object.getCaseBranches().get(i));
        _builder_1.append(_visit_1, "\t");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("}");
        sb.append(_builder_1);
      }
    }
    Rule _otherwiseBranch = object.getOtherwiseBranch();
    boolean _tripleNotEquals = (_otherwiseBranch != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("else{ ");
      _builder.newLine();
      _builder.append(" \t");
      String _visit = new RuleToCpp(this.res, this.seqBlock, this.options).visit(object.getOtherwiseBranch());
      _builder.append(_visit, " \t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      sb.append(_builder);
    }
    return sb.toString();
  }
  
  public String compareTerms(final Term leftTerm, final Term rightTerm) {
    int _compareTo = leftTerm.getDomain().toString().compareTo(rightTerm.getDomain().toString());
    boolean _notEquals = (_compareTo != 0);
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Impossible to compare Terms");
      return _builder.toString();
    } else {
      if ((leftTerm instanceof StringDomain)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _visit = new TermToCpp(this.res).visit(leftTerm);
        _builder_1.append(_visit);
        _builder_1.append(".compare(");
        String _visit_1 = new TermToCpp(this.res).visit(rightTerm);
        _builder_1.append(_visit_1);
        _builder_1.append(")==0");
        return _builder_1.toString();
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        String _visit_2 = new TermToCpp(this.res).visit(leftTerm);
        _builder_2.append(_visit_2);
        _builder_2.append("==");
        String _visit_3 = new TermToCpp(this.res).visit(rightTerm);
        _builder_2.append(_visit_3);
        return _builder_2.toString();
      }
    }
  }
  
  @Override
  public String visit(final ChooseRule object) {
    int counter = 0;
    StringBuffer sb = new StringBuffer();
    for (int i = 0; (i < object.getRanges().size()); i++) {
      Domain _domain = object.getRanges().get(i).getDomain();
      if ((_domain instanceof PowersetDomain)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("set<const ");
        Domain _domain_1 = object.getRanges().get(i).getDomain();
        String _visit = new ToString(this.res).visit(((PowersetDomain) _domain_1).getBaseDomain());
        _builder.append(_visit);
        _builder.append("*> point");
        _builder.append(i);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        sb.append(_builder);
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("NOT IMPLEMENTED IN C++ (RuleToCpp line 264)");
        _builder_1.newLine();
        sb.append(_builder_1);
      }
    }
    for (int i = 0; (i < object.getRanges().size()); i++) {
      Domain _domain = object.getRanges().get(i).getDomain();
      if ((_domain instanceof PowersetDomain)) {
        Domain _domain_1 = object.getRanges().get(i).getDomain();
        boolean _isNotNumerable = new Util().isNotNumerable(((PowersetDomain) _domain_1).getBaseDomain());
        if (_isNotNumerable) {
          StringConcatenation _builder = new StringConcatenation();
          String _visit = new DomainToH(this.res).visit(object.getRanges().get(i).getDomain());
          _builder.append(_visit);
          _builder.append(" ");
          Domain _domain_2 = object.getRanges().get(i).getDomain();
          String _visit_1 = new ToString(this.res).visit(((PowersetDomain) _domain_2).getBaseDomain());
          String _plus = (_visit_1 + Integer.valueOf(i));
          _builder.append(_plus);
          _builder.append("_elems = ");
          String _visit_2 = new TermToCpp(this.res).visit(object.getRanges().get(i));
          _builder.append(_visit_2);
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          sb.append(_builder);
          counter = (counter + 1);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("for(auto const& ");
          String _visit_3 = new TermToCpp(this.res).visit(object.getVariable().get(i));
          _builder_1.append(_visit_3);
          _builder_1.append(" : ");
          Domain _domain_3 = object.getRanges().get(i).getDomain();
          String _visit_4 = new ToString(this.res).visit(((PowersetDomain) _domain_3).getBaseDomain());
          String _plus_1 = (_visit_4 + Integer.valueOf(i));
          _builder_1.append(_plus_1);
          _builder_1.append("_elems){");
          _builder_1.newLineIfNotEmpty();
          sb.append(_builder_1);
        } else {
          Domain _domain_4 = object.getRanges().get(i).getDomain();
          Domain _baseDomain = ((PowersetDomain) _domain_4).getBaseDomain();
          if ((_baseDomain instanceof AbstractTd)) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("for(const auto& ");
            String _visit_5 = new TermToCpp(this.res).visit(object.getVariable().get(i));
            _builder_2.append(_visit_5);
            _builder_2.append(" : ");
            Domain _domain_5 = object.getRanges().get(i).getDomain();
            String _visit_6 = new ToString(this.res).visit(((PowersetDomain) _domain_5).getBaseDomain());
            _builder_2.append(_visit_6);
            _builder_2.append("::elems)");
            _builder_2.newLineIfNotEmpty();
            sb.append(_builder_2);
          } else {
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("for(auto const& ");
            String _visit_7 = new TermToCpp(this.res).visit(object.getVariable().get(i));
            _builder_3.append(_visit_7);
            _builder_3.append(" : ");
            Domain _domain_6 = object.getRanges().get(i).getDomain();
            String _visit_8 = new ToString(this.res).visit(((PowersetDomain) _domain_6).getBaseDomain());
            _builder_3.append(_visit_8);
            _builder_3.append("_elems)");
            _builder_3.newLineIfNotEmpty();
            sb.append(_builder_3);
          }
        }
      } else {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("//NOT IMPLEMENTED IN C++ (RuleToCpp line 283)\t");
        _builder_4.newLine();
        sb.append(_builder_4);
      }
    }
    Term _guard = object.getGuard();
    boolean _tripleNotEquals = (_guard != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if(");
      String _visit = new TermToCpp(this.res).visit(object.getGuard());
      _builder.append(_visit);
      _builder.append("){");
      _builder.newLineIfNotEmpty();
      sb.append(_builder);
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("{");
      _builder_1.newLine();
      sb.append(_builder_1);
    }
    for (int i = 0; (i < object.getVariable().size()); i++) {
      Domain _domain = object.getRanges().get(i).getDomain();
      Domain _baseDomain = ((PowersetDomain) _domain).getBaseDomain();
      if ((_baseDomain instanceof AbstractTd)) {
        String termName = new TermToCpp(this.res).visit(object.getVariable().get(i));
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("point");
        _builder_2.append(i);
        _builder_2.append(".push_back(&(*");
        _builder_2.append(termName);
        _builder_2.append("));");
        _builder_2.newLineIfNotEmpty();
        sb.append(_builder_2);
      } else {
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("point");
        _builder_3.append(i);
        _builder_3.append(".push_back(&");
        String _visit_1 = new TermToCpp(this.res).visit(object.getVariable().get(i));
        _builder_3.append(_visit_1);
        _builder_3.append(");");
        _builder_3.newLineIfNotEmpty();
        sb.append(_builder_3);
      }
    }
    for (int i = 0; (i < counter); i++) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("}");
      _builder_2.newLine();
      sb.append(_builder_2);
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("}");
    _builder_2.newLine();
    sb.append(_builder_2);
    if (this.options.shuffleRandom) {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("int rndm = rand() % point0.size();");
      _builder_3.newLine();
      sb.append(_builder_3);
    } else {
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("int rndm = 0;");
      _builder_4.newLine();
      sb.append(_builder_4);
    }
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("{");
    _builder_5.newLine();
    sb.append(_builder_5);
    for (int i = 0; (i < object.getVariable().size()); i++) {
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("auto ");
      String _visit_1 = new TermToCpp(this.res).visit(object.getVariable().get(i));
      _builder_6.append(_visit_1);
      _builder_6.append(" = *point");
      _builder_6.append(i);
      _builder_6.append("[rndm];");
      _builder_6.newLineIfNotEmpty();
      sb.append(_builder_6);
    }
    Rule _ifnone = object.getIfnone();
    boolean _tripleNotEquals_1 = (_ifnone != null);
    if (_tripleNotEquals_1) {
      String doRule = this.visit(object.getDoRule());
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("  ");
      _builder_6.append("if(point0.size()>0){");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append(doRule, "\t");
      _builder_6.newLineIfNotEmpty();
      _builder_6.append("\t ");
      _builder_6.append("}else{");
      _builder_6.newLine();
      _builder_6.append("\t \t");
      String _visit_1 = this.visit(object.getIfnone());
      _builder_6.append(_visit_1, "\t \t");
      _builder_6.newLineIfNotEmpty();
      _builder_6.append("\t ");
      _builder_6.append("}");
      _builder_6.newLine();
      _builder_6.append("}");
      sb.append(_builder_6);
    } else {
      String doRule_1 = this.visit(object.getDoRule());
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("  ");
      _builder_7.append("if(point0.size()>0){");
      _builder_7.newLine();
      _builder_7.append("\t");
      _builder_7.append(doRule_1, "\t");
      _builder_7.newLineIfNotEmpty();
      _builder_7.append("\t ");
      _builder_7.append("}");
      _builder_7.newLine();
      _builder_7.append("}");
      sb.append(_builder_7);
    }
    return sb.toString();
  }
  
  @Override
  public String visit(final ForallRule object) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; (i < object.getRanges().size()); i++) {
      Domain _domain = object.getRanges().get(i).getDomain();
      Domain _baseDomain = ((PowersetDomain) _domain).getBaseDomain();
      if ((_baseDomain instanceof AbstractTd)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("for(auto ");
        String _visit = new TermToCpp(this.res).visit(object.getVariable().get(i));
        _builder.append(_visit);
        _builder.append(" : ");
        Domain _domain_1 = object.getRanges().get(i).getDomain();
        String _visit_1 = new ToString(this.res).visit(((PowersetDomain) _domain_1).getBaseDomain());
        _builder.append(_visit_1);
        _builder.append("::elems)");
        _builder.newLineIfNotEmpty();
        sb.append(_builder);
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("for(auto ");
        String _visit_2 = new TermToCpp(this.res).visit(object.getVariable().get(i));
        _builder_1.append(_visit_2);
        _builder_1.append(" : ");
        Domain _domain_2 = object.getRanges().get(i).getDomain();
        String _visit_3 = new ToString(this.res).visit(((PowersetDomain) _domain_2).getBaseDomain());
        _builder_1.append(_visit_3);
        _builder_1.append("_elems)");
        _builder_1.newLineIfNotEmpty();
        sb.append(_builder_1);
      }
    }
    Term _guard = object.getGuard();
    boolean _tripleNotEquals = (_guard != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("if(");
      String _visit = new TermToCpp(this.res).visit(object.getGuard());
      _builder.append(_visit, "\t");
      _builder.append("){\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      String _visit_1 = this.visit(object.getDoRule());
      _builder.append(_visit_1, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      sb.append(_builder);
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("\t");
      String _visit_2 = this.visit(object.getDoRule());
      _builder_1.append(_visit_2, "\t");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("}");
      _builder_1.newLine();
      sb.append(_builder_1);
    }
    return sb.toString();
  }
  
  @Override
  public String visit(final LetRule object) {
    StringBuffer let = new StringBuffer();
    let.append("{\n");
    for (int i = 0; (i < object.getVariable().size()); i++) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("auto ");
      String _visit = new TermToCpp(this.res).visit(object.getVariable().get(i));
      _builder.append(_visit);
      _builder.append(" = ");
      String _visit_1 = new TermToCpp(this.res).visit(object.getInitExpression().get(i));
      _builder.append(_visit_1);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      let.append(_builder);
    }
    StringConcatenation _builder = new StringConcatenation();
    String _visit = new RuleToCpp(this.res, this.seqBlock, this.options).visit(object.getInRule());
    _builder.append(_visit);
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    let.append(_builder);
    return let.toString();
  }
  
  public String visit(final IterativeWhileRule object) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while (");
    String _visit = new TermToCpp(this.res, false).visit(object.getGuard());
    _builder.append(_visit);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _visit_1 = new RuleToCpp(this.res, true, this.options).visit(object.getRule());
    _builder.append(_visit_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  /**
   * TODO: iterateRule
   */
  public String visit(final IterateRule object) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//#iterate rule not yet implemented");
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  public String visit(final ConditionalRule object) {
    Rule _elseRule = object.getElseRule();
    boolean _tripleEquals = (_elseRule == null);
    if (_tripleEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if (");
      String _visit = new TermToCpp(this.res).visit(object.getGuard());
      _builder.append(_visit);
      _builder.append("){ ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _visit_1 = new RuleToCpp(this.res, this.seqBlock, this.options).visit(object.getThenRule());
      _builder.append(_visit_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    } else {
      Rule _elseRule_1 = object.getElseRule();
      if ((_elseRule_1 instanceof ConditionalRule)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("if (");
        String _visit_2 = new TermToCpp(this.res).visit(object.getGuard());
        _builder_1.append(_visit_2);
        _builder_1.append("){ ");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t\t");
        String _visit_3 = new RuleToCpp(this.res, this.seqBlock, this.options).visit(object.getThenRule());
        _builder_1.append(_visit_3, "\t\t");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("} else ");
        String _visit_4 = new RuleToCpp(this.res, this.seqBlock, this.options).visit(object.getElseRule());
        _builder_1.append(_visit_4);
        _builder_1.newLineIfNotEmpty();
        return _builder_1.toString();
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("\t");
        _builder_2.append("if (");
        String _visit_5 = new TermToCpp(this.res).visit(object.getGuard());
        _builder_2.append(_visit_5, "\t");
        _builder_2.append("){ ");
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("\t");
        String _visit_6 = new RuleToCpp(this.res, this.seqBlock, this.options).visit(object.getThenRule());
        _builder_2.append(_visit_6, "\t");
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("\t");
        _builder_2.append("}else{");
        _builder_2.newLine();
        _builder_2.append("\t");
        String _visit_7 = new RuleToCpp(this.res, this.seqBlock, this.options).visit(object.getElseRule());
        _builder_2.append(_visit_7, "\t");
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("}");
        _builder_2.newLine();
        return _builder_2.toString();
      }
    }
  }
  
  /**
   * '''
   * 	#ifdef ARDUINOCOMPILER
   * 	Serial.print(" + new ToString(res).visit(object.term) + ");
   * 	  #endif
   * '''
   * }
   */
  @Override
  public String visit(final TermAsRule rule) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String visit(final ExtendRule rule) {
    StringBuffer string = new StringBuffer();
    for (int i = 0; (i < rule.getBoundVar().size()); i++) {
      String _visit = new DomainToH(this.res, true).visit(rule.getExtendedDomain());
      String _plus = (_visit + " ");
      String _visit_1 = new TermToCpp(this.res).visit(rule.getBoundVar().get(i));
      String _plus_1 = (_plus + _visit_1);
      String _plus_2 = (_plus_1 + " = new ");
      String _visit_2 = new DomainToH(this.res).visit(rule.getExtendedDomain());
      String _plus_3 = (_plus_2 + _visit_2);
      String _plus_4 = (_plus_3 + "();\n");
      string.append(_plus_4);
    }
    String _string = string.toString();
    String _visit = new RuleToCpp(this.res, this.seqBlock, this.options).visit(rule.getDoRule());
    return (_string + _visit);
  }
}
