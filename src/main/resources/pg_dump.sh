#!/usr/bin/env bash
export PGPASSWORD=root;
pg_dump -U root stockmanager > ~/dev/study/stockmanager.dump