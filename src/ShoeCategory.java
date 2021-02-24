import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 1:13 PM
 * Project Database
 */
public class ShoeCategory {
        protected int id;
        protected Shoes shoe;
        protected List<Category> categoryList;

        public ShoeCategory (int id, Shoes shoe, List<Category> categoryList) {
            this.id = id;
            this.shoe = shoe;
            categoryList = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Shoes getShoe() {
            return shoe;
        }

        public void setShoe(Shoes shoe) {
            this.shoe = shoe;
        }

        public List<Category> getCategoryList() {
            return categoryList;
        }

        public void addCategoryId (Category categoryId){
            categoryList.add(categoryId);
        }
}
