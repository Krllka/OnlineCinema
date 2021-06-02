package backend.services.Intrfaces;

import backend.model.AccountData;
import backend.response.Response;

public interface AccountDataService extends AbstractServiceInterface<AccountData> {
    public Response tryAuth(String client, String pass);
}