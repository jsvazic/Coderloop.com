(import '(java.sql DriverManager Connection PreparedStatement ResultSet))
(Class/forName "com.mysql.jdbc.Driver")

(def db-user (str (first *command-line-args*)))
(def db-pass (str (first (rest *command-line-args*))))
(def db-url (str "jdbc:mysql://localhost:3306/" (first (rest (rest *command-line-args*)))))

(def conn (. DriverManager (getConnection db-url db-user db-pass)))
(def rs (.. conn (prepareStatement "SELECT text FROM hello_data ORDER BY id ASC;") (executeQuery)))
(def rset (resultset-seq rs))

(println (apply str (interpose " " (map #(:text %) rset))))
