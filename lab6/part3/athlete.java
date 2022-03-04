package lab6.part3;

public class athlete {
        float height;
        float salary;
        float weight;
        String gender;
        String name;

        athlete(String n, float w, float h, String g, float s){
            this.height = h;
            this.weight = w;
            this.gender = g;
            this.salary = s;
            this.name = n;
        }
        public String getName(){
            return this.name;
        }
        public float getHeight(){
            return this.height;
        }
        public float getweight(){
            return this.weight;
        }
        public float getsalary(){
            return this.salary;
        }
        public String getGender(){
            return this.gender;
        }

}
