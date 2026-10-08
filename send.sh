#!/usr/bin/env bash
curl -X POST -H 'Content-Type: text/plain' -d "${1:-ciao rabbit}" localhost:8080/messages
echo
