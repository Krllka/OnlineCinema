package backend.response;


    public class Response{
        private  Boolean exist;
        private  Boolean access;
        private  Boolean admin;
        private  String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getExist() {
            return exist;
        }

        public void setExist(Boolean exist) {
            this.exist = exist;
        }

        public Boolean getAccess() {
            return access;
        }

        public void setAccess(Boolean access) {
            this.access = access;
        }

        public Boolean getAdmin() {
            return admin;
        }

        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }

        public Response(){
            access = false;
            admin = false;
            exist = false;
        }


    }

