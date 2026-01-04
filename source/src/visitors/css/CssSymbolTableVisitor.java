package visitors.css;

import classes.css.*;
import symbols.css.*;

public class CssSymbolTableVisitor {

    private final CssSymbolTable table = new CssSymbolTable();

    public CssSymbolTable build(CssStylesheet sheet) {
        visitStylesheet(sheet);
        return table;
    }

    private void visitStylesheet(CssStylesheet sheet) {
        for (CssRuleSet r : sheet.ruleSets) {
            visitRuleSet(r);
        }
        for (CssMediaRule m : sheet.mediaRules) {
            visitMediaRule(m);
        }
    }

    private void visitMediaRule(CssMediaRule media) {
        visitRuleSetList(media.ruleSets);
    }

    private void visitRuleSetList(Iterable<CssRuleSet> ruleSets) {
        for (CssRuleSet r : ruleSets) {
            visitRuleSet(r);
        }
    }

    private void visitRuleSet(CssRuleSet rule) {

        // selectors
        for (CssSelector s : rule.selectors) {
            for (CssSimpleSelector part : s.parts) {
                table.define(
                        new SelectorSymbol(
                                part.toString(),
                                part.getLine()
                        )
                );
            }
        }

        // declarations (properties)
        for (CssDeclaration d : rule.declarations) {
            table.define(
                    new PropertySymbol(
                            d.property,
                            d.getLine()
                    )
            );
        }
    }
}
