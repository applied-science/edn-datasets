# EDN datasets

>You've asked me what the lobster is weaving there with his golden feet?<br/>
>I reply, the ocean knows this.<br/>
>You say, what is the ascidia waiting for in its transparent bell?<br/>
>What is it waiting for?<br/>
>I tell you it is waiting for time, like you.<br/>
>You ask me whom the Macrocystis alga hugs in its arms?<br/>
>Study, study it, at a certain hour, in a certain sea I know.<br/>
>You question me about the wicked tusk of the narwhal, and I reply by describing<br/>
>How the sea unicorn with the harpoon in it dies.<br/>
>You enquire about the kingfisher's feathers,<br/>
>which tremble in the pure springs of the southern tides?<br/>
>Or you've found in the cards a new question touching on the crystal architecture<br/>
>of the sea anemone, and you'll deal that to me now?<br/>

– Pablo Neruda, _Enigmas_

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

