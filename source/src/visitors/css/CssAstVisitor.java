package visitors.css;

import classes.css.*;
import antlr.ParserCss;
import antlr.ParserCssBaseVisitor;

public class CssAstVisitor extends ParserCssBaseVisitor<CssNode> {


    @Override
    public CssNode visitStylesheet(ParserCss.StylesheetContext ctx) {

        CssStylesheet sheet =
                new CssStylesheet(ctx.getStart().getLine());

        for (ParserCss.RuleSetContext rs : ctx.ruleSet()) {
            sheet.ruleSets.add((CssRuleSet) visit(rs));
        }

        for (ParserCss.MediaRuleContext mr : ctx.mediaRule()) {
            sheet.mediaRules.add((CssMediaRule) visit(mr));
        }

        return sheet;
    }

    @Override
    public CssNode visitMediaRule(ParserCss.MediaRuleContext ctx) {

        CssMediaCondition condition =
                (CssMediaCondition) visit(ctx.mediaCondition());

        CssMediaRule mediaRule =
                new CssMediaRule(ctx.getStart().getLine(), condition);

        for (ParserCss.RuleSetContext rs : ctx.ruleSet()) {
            mediaRule.ruleSets.add((CssRuleSet) visit(rs));
        }

        return mediaRule;
    }

    @Override
    public CssNode visitMediaCondition(ParserCss.MediaConditionContext ctx) {

        return new CssMediaCondition(
                ctx.getStart().getLine(),
                ctx.IDENT().getText(),
                (CssValue) visit(ctx.value())
        );
    }


    @Override
    public CssNode visitRuleSet(ParserCss.RuleSetContext ctx) {

        CssRuleSet ruleSet =
                new CssRuleSet(ctx.getStart().getLine());

        for (ParserCss.SelectorContext sel : ctx.selectorList().selector()) {
            ruleSet.selectors.add((CssSelector) visit(sel));
        }

        for (ParserCss.DeclarationContext dec : ctx.declaration()) {
            ruleSet.declarations.add((CssDeclaration) visit(dec));
        }

        return ruleSet;
    }

    @Override
    public CssNode visitSelector(ParserCss.SelectorContext ctx) {

        CssSelector selector =
                new CssSelector(ctx.getStart().getLine());

        for (ParserCss.SimpleSelectorContext part : ctx.simpleSelector()) {
            selector.parts.add((CssSimpleSelector) visit(part));
        }

        return selector;
    }

    @Override
    public CssNode visitUniversalSelector(ParserCss.UniversalSelectorContext ctx) {
        return new CssUniversalSelector(ctx.getStart().getLine());
    }

    @Override
    public CssNode visitTypeSelector(ParserCss.TypeSelectorContext ctx) {
        return new CssTypeSelector(
                ctx.getStart().getLine(),
                ctx.IDENT().getText()
        );
    }

    @Override
    public CssNode visitClassSelector(ParserCss.ClassSelectorContext ctx) {
        return new CssClassSelector(
                ctx.getStart().getLine(),
                ctx.IDENT().getText()
        );
    }

    @Override
    public CssNode visitIdSelector(ParserCss.IdSelectorContext ctx) {
        return new CssIdSelector(
                ctx.getStart().getLine(),
                ctx.IDENT().getText()
        );
    }

    @Override
    public CssNode visitPseudoClassSelector(
            ParserCss.PseudoClassSelectorContext ctx) {

        return new CssTypeSelector(
                ctx.getStart().getLine(),
                ":" + ctx.IDENT().getText()
        );
    }


    @Override
    public CssNode visitDeclaration(ParserCss.DeclarationContext ctx) {

        return new CssDeclaration(
                ctx.getStart().getLine(),
                ctx.property().IDENT().getText(),
                (CssValue) visit(ctx.value())
        );
    }


    @Override
    public CssNode visitColorValue(ParserCss.ColorValueContext ctx) {
        return new CssLiteralValue(
                ctx.getStart().getLine(),
                ctx.HEXCOLOR().getText()
        );
    }

    @Override
    public CssNode visitNumberValue(ParserCss.NumberValueContext ctx) {

        String value = ctx.NUMBER().getText();
        if (ctx.UNIT() != null) {
            value += ctx.UNIT().getText();
        }

        return new CssLiteralValue(ctx.getStart().getLine(), value);
    }

    @Override
    public CssNode visitStringValue(ParserCss.StringValueContext ctx) {
        return new CssLiteralValue(
                ctx.getStart().getLine(),
                ctx.STRING().getText()
        );
    }

    @Override
    public CssNode visitIdentifierValue(ParserCss.IdentifierValueContext ctx) {
        return new CssLiteralValue(
                ctx.getStart().getLine(),
                ctx.IDENT().getText()
        );
    }

    @Override
    public CssNode visitFunctionValue(ParserCss.FunctionValueContext ctx) {
        return new CssLiteralValue(
                ctx.getStart().getLine(),
                ctx.getText()
        );
    }
}
