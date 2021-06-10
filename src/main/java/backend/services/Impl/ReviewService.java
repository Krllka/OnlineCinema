package backend.services.Impl;

import backend.DAO.Impl.ProdGenreDAOimpl;
import backend.DAO.Impl.ReviewDAO;
import backend.model.Review;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReviewService extends AbsctractService<Review, ReviewDAO>
        implements AbstractServiceInterface<Review> {
    ReviewService(ReviewDAO dao ){
        super(dao);
    }
}
