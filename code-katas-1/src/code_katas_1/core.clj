(ns code-katas-1.core)

(defn filter-odd
  "Escribir una funcion que retorne solamente los numeros impares de
   una secuencia"
  [s]
  (filter #(= 1 (rem % 2)) s)
  )

(defn nil-key
  "Escribir una funcion que dada una clave y un mapa, devuelva true, solamente si el mapa
   contiene una entrada con esa clave, y su valor es nil"
  [k m]
  (if (contains? m k) (if (nil? (get m k)) true false) false)
  )

(defn range
  "Escribir una funcion que cree una lista de enteros en un rango dado.
   Restricciones: range"
  [start end]
  (take (- end start) (iterate inc start))
  )

(defn compress-sequence
  "Escribir una funcion que elimine los duplicados consecutivos
   de una secuencia"
  [s]
  (def anterior "-")
  (filter #(do (def anterior2 anterior) (def anterior %) (not= % anterior2)) s)
  )

(defn max-value
  "Escribir una funcion que reciba un numero variable de parametros
   y retorne el que tenga el valor mayor
   Restricciones: max y max-key"
  [& args]
  (def maximo (first args))
  (last (filter #(if (>= % maximo) (do (def maximo %) true) false) args))
  )

(defn split-two
  "Escribir una funcion que parta una secuencia en dos partes
   Restricciones: split-at"
  [length s]
  [(vec (take length s)) (vec (take-last (- (count s) length) s))]
  )


(defn inter-two
  "Escribir una funcion que reciba dos secuencias y retorne el primero de cada una,
   luego el segundo de cada una, luego el tercero, etc.
   Restricciones: interleave"
  [s1 s2]
  (for [x (range 0 (* 2 (min (count s1) (count s2))))] (if (odd? x) (nth s2 (quot x 2)) (nth s1 (quot x 2))))
  )

(defn retrieve-caps
  "Escribir una funcion que reciba un string y devuelva un nuevo string conteniendo
   solamente las mayusculas."
  [text]
  (apply str (filter #(> 97 (int %) 64) text))
  )


(defn find-truth
  "Escribir una funcion que tome un numero variable de booleans, y devuelva true
   solamente si alguno de los parametros son true, pero no todos son true. En otro
   caso debera retornar false"
  [& xs]
  (< 0 (reduce + (map #(if (true? %) 1 0) xs)) (count xs))
  )

(defn zip-map
  "Escribir una funcion que reciba un vector de claves y un vector de valores, y
   construya un mapa a partir de ellos.
   Restricciones: zipmap"
  [k v]
  (reduce merge (for [x (range 0 (min (count k) (count v)))] (hash-map (nth k x) (nth v x))))
  )
