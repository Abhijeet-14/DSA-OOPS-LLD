# GIT Technique & shortcuts

**COMMIT AND ADD:**

    git commit -am "commit commit"

**NO OF COMMITS:**

    git rev-list --count <HEAD | main | master > [specific to HEAD pointed branch]

    git rev-list --all --count   [all branch commits]

**STORE IN VARIABLE:**

    [create alias] git config --global alias.ac "commit -am"

    this will add and commit

    $ git ac "noice"

**UPDATE LAST COMMIT MESSAGE:**

    git commit --amend -m "nice"

    [or add other file with changing names]:

    $ git commit --amend --no-edit

**REVERT: [undo commit with new commit ]**

    git revert`<Commit message>`

**REBASE:**

**MERGE:**

**GIT LOG:**

    git log --oneline

    git log --graph --oneline --decorate

**STASH:**

    git stash [remove from cwd and save for later use w/o commiting to repo]

    git stash pop [add all stashed changes to repo]

    git stash save`<satsh-name>`

    git stash list

    git stash apply`<index of the name from previous list>`

**BISECT:**

    git bisect start

    git bisect bad

    git bisect good`<commit id>`

**HOOKS:**

**GO TO PREVIOUS BRANCH:**

    $ git checkout -

**DESTRUCTION:**

    Caution: [this will change all local files to remote files]

    git fetch origin

    git reset --hard origin/master
