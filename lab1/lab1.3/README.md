Source code management using Git

Git basics

Useful tutorial: https://www.atlassian.com/git/tutorials/learn-git-with-bitbucket-cloud


Creating a repo:
 
    This step is pretty intuitive when using a hosting service like GitHub or BitBucket, but refer to the tutorial if help is needed.


Adding a project to Git versioning:

    Pushing a new project/file into the repo:
        (in this example we are pushing the project 'weatherApp' into my repo IES_104063)


    cd ...\lab1\lab1.2  <Project Folder>  #move to the root of the working folder to be imported
    git init                                # initialize a local git repo in this folder
    git remote add origin https://github.com/AnaSL-WRK/IES_104063.git <REMOTE_URL> #connecting to our repo
    git add .                       # mark all existing changes in this root to be commited (moved to staging area)
    git commit -m "Initial project setup for exercise 1_3" #moves the files from staging area to your local git     repo, with a comment 
    git push -u origin main         #uploads the local commit to the shared repo


                   



errors that happened:
        error: failed to push some refs to 'https://github.com/AnaSL-WRK/IES_104063.git'
            solution: git pull --rebase origin main   (gets the files in the remote repo to local)
            and add the project again

        error: 'weatherApp' does not have a commit checked out 
        fatal: adding files failed
            cause: created a .git  in a subfolder
            solution: delete the .git folder (may have to activate 'view hidden folders')
                        git status   #if you want to check the files 'deleted'
                        git restore . 



useful commands:
    git status
    git reset HEAD <YOUR-FILE>  to unstage a file (be sure to use your file write your file extension)
    git reset HEAD .  to unstage all files

> note : because I created the .gitignore after I already pushed the project, to "activate it" you have to:
            git pull https://github.com/AnaSL-WRK/IES_104063.git
            git add .gitignore
            git commit
            git push


Colaboration simulation:
    
    In this case we are creating a folder outside our repo, acting as if we are a collaborator on a different computer, and then merging to our project

    git clone https://github.com/AnaSL-WRK/IES_104063.git (in the directory you want to work on)
     *make the changes you want*
    git add
    git commit 
    git push

    other option you have is to create a branch where you want to work on:

    (cd repo directory or pull repo)
    git branch coolbranch       #creating the branch
    git checkout future-plans   #switching to the branch
    (git status will always show what branch are you working on)
        *make the changes you want*
    git add
    git commit 
    git push

    > now your changes exist in the project timeline, but on yet on the project itself
        for that we are going to merge them

    git checkout main (or master, depending on the version youre using)
    git merge future-plans #now your project is all updated!
    git branch -d future-plans #delete your branch since you wont use it anymore

