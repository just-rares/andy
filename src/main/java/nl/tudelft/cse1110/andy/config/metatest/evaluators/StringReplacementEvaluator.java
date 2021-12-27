package nl.tudelft.cse1110.andy.config.metatest.evaluators;

public class StringReplacementEvaluator implements MetaEvaluator {

    private String old;
    private String replacement;

    public StringReplacementEvaluator(String old, String replacement) {
        this.old = old;
        this.replacement = replacement;
    }

    @Override
    public String evaluate(String oldLibraryCode) {
        String shiftedOld = this.old.replaceAll("(?m)^\\s+", "");
        String shiftedOldLibraryCode = oldLibraryCode.replaceAll("(?m)^\\s+", "");
        String replaced = shiftedOldLibraryCode.replace(shiftedOld, this.replacement);

        if (replaced.equals(oldLibraryCode)) {
            throw new RuntimeException("Meta test failed to find this text replacement:\n" + this.old);
        }

        return replaced;
    }
}
