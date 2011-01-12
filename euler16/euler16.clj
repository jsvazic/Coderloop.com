(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(def my-pow (Integer/valueOf (process-file (first *command-line-args*))))
(def my-num (str (reduce * (repeat my-pow 2))))
(println (reduce + (doall (map #(reduce + %) (partition 1 1 (map #(Integer/valueOf (str %)) my-num))))))