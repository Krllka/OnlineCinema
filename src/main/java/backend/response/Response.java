package backend.response;


    public class Response{
        private  Boolean access;
        private  Boolean admin;

        public Boolean getAcces() {
            return access;
        }

        public void setAcces(Boolean acces) {
            this.access = acces;
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
        }


    }

