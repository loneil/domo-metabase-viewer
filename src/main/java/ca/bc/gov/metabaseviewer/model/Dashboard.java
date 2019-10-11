package ca.bc.gov.metabaseviewer.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Dashboard {
    private final String displayName;
    private final int metabaseId;
    private boolean currentlySelected = false;
}
