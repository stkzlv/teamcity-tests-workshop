package org.workshop.api.requests.checkedRequests;

import org.workshop.api.requests.uncheckedRequests.UncheckedRequests;

public interface CheckedRequestInterface {
    UncheckedRequests unchecked = new UncheckedRequests();

    public Object create(Object dto);

    public Object get(String id);

    public Object update(Object dto);

    public void delete(String id);
}
