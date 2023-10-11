#! /usr/bin/env bash

mkdir -p dist
cd ..
cp ./code/extensions/asmeta.validator/asmeta.validator/dist/AsmetaV.jar docker/dist/.
cp ./code/extensions/asmeta.flattener/asmeta.flattener.cli/dist/AsmetaF.jar docker/dist/.
cp ./code/extensions/asmetasmv/asmeta.smv/dist/AsmetaSMV.jar docker/dist/.
cp ./code/extensions/asmeta.modeladvisor/asmeta.modeladvisor/dist/AsmetaMA.jar docker/dist/.
cp ./code/extensions/asmeta.refprover/translatorToSMT/dist/AsmetaToSMT.jar docker/dist/.
cp ./code/extensions/asmeta.refprover/refinementProof/dist/AsmetaRefProver.jar docker/dist/.
cp ./code/core/asmeta.parser/asmeta.parser.cli/dist/AsmetaLc.jar docker/dist/.
cp ./code/core/asmeta.simulator/asmeta.simulator.cli/dist/AsmetaS.jar docker/dist/.
cp ./code/experimental/asmetal2cpp/asmetal2cpp_cli/dist/Asmeta2Cpp.jar docker/dist/.
cd -

sudo docker build -t podhrmic/asmeta:latest .
sudo docker push podhrmic/asmeta:latest
