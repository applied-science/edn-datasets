# EDN datasets

Datasets in [extensible data notation](https://github.com/edn-format/edn).

For Clojurians who just want to grab Anscombe's quartet or Anderson's irises and get on with it, without worrying about CSV parsing or picking a JSON library.



## Usage
1. For your deps.edn:

```clojure
applied-science/edn-datasets {:git/url "git@github.com:applied-science/edn-datasets.git"
                              :sha "02e5809d3ac84e254ef49f56d7051fb776a8c889"}
```

2. Add `[applied-science.edn-datasets :as data]` to your requires.

3. Eval `data/anscombe` or another var, or access an EDN resource directly with something like `(clojure.java.io/resource "iris.edn")`



## MIT License
See LICENSE file in the root directory.

Copyright (c) 2022 Applied Science Studio

