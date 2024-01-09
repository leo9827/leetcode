#!/bin/bash

export FILTER_BRANCH_SQUELCH_WARNING=1 # This will suppress the warning shown by git

git filter-branch --commit-filter '
        if [ "$GIT_AUTHOR_EMAIL" = "knowlovelh@gmail.com" ];
        then
                GIT_AUTHOR_NAME="leo9827";
                GIT_AUTHOR_EMAIL="741829374@qq.com";
                git commit-tree "$@";
        else
                git commit-tree "$@";
        fi' HEAD
