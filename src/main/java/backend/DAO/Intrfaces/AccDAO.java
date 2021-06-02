package backend.DAO.Intrfaces;

import backend.model.AccountData;
import backend.response.Response;
import org.springframework.stereotype.Repository;


public interface AccDAO extends  AbstractRepo<AccountData> {
    public Response tryAuth(String client, String pass);
}
