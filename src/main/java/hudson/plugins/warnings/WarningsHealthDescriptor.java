package hudson.plugins.warnings;

import hudson.plugins.warnings.util.AbstractHealthDescriptor;
import hudson.plugins.warnings.util.HealthDescriptor;
import hudson.plugins.warnings.util.model.AnnotationProvider;

import org.jvnet.localizer.Localizable;

/**
 * A health descriptor for CheckStyle build results.
 *
 * @author Ulli Hafner
 */
public class WarningsHealthDescriptor extends AbstractHealthDescriptor {
    /** Unique ID of this class. */
    private static final long serialVersionUID = -3404826986876607396L;

    /**
     * Creates a new instance of {@link WarningsHealthDescriptor} based on the
     * values of the specified descriptor.
     *
     * @param healthDescriptor the descriptor to copy the values from
     */
    public WarningsHealthDescriptor(final HealthDescriptor healthDescriptor) {
        super(healthDescriptor);
    }

    /** {@inheritDoc} */
    @Override
    protected Localizable createDescription(final AnnotationProvider result) {
        if (result.getNumberOfAnnotations() == 0) {
            return Messages._Warnings_ResultAction_HealthReportNoItem();
        }
        else if (result.getNumberOfAnnotations() == 1) {
            return Messages._Warnings_ResultAction_HealthReportSingleItem();
        }
        else {
            return Messages._Warnings_ResultAction_HealthReportMultipleItem(result.getNumberOfAnnotations());
        }
    }
}
