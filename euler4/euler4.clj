(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(def digit-count (Integer/valueOf (process-file (first *command-line-args*))))
(def min-num (dec (reduce * (repeat (dec digit-count) 10))))
(def max-num (dec (reduce * (repeat digit-count 10))))

(defn palindrome? [n] (= (str n) (apply str (reverse (str n)))))

(defn euler4 []
  (loop [i max-num last-pal 1 max-pal 0]
    (if (< last-pal max-pal)
	  max-pal
	  (let [col (filter palindrome? (map #(* i %) (range min-num i)))
	        new-last (if (empty? col) 1 (reduce max col))
		    new-max (max max-pal new-last)]
	      (recur (dec i) new-last new-max)))))

(time (euler4))