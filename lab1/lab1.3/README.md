# Lab 1.3: Source code management using Git

Ana Loureiro, 104063, UA

Useful tutorial: [Learn Git with Bitbucket Cloud](https://www.atlassian.com/git/tutorials/learn-git-with-bitbucket-cloud)


## Git basics: Creating a repo
 
 This step is pretty intuitive when using a hosting service like [GitHub](https://github.com) or [BitBucket](https://bitbucket.org), but refer to the tutorial if help is needed.
<br>

## Adding a project to Git versioning

### Pushing a new project/file into the repo:

In this example we are pushing the project 'weatherApp' into my repo IES_104063
<br>

```git
cd ...\lab1\lab1.2
git init   
git remote add origin https://github.com/AnaSL-WRK/IES_104063.git (Remote Url)   
git add . 
git commit -m "Initial project setup for exercise 1_3" 
git push -u origin main  
```

<br>

**What we did:**
1. changed the directory to the root of the folder to be imported 
2. initialize a local git repo in this folder
3. connected to our repo
4. marked all existing changes in this root to be commited (moving everything to the staging area)  
5. moved the files from staging area to your local git repo attached with a description
6. uploaded the local commit to the shared repo 
                   
<br>


> Because I created the .gitignore after I already pushed the project, to "activate it" you have to:
> ```
>git pull https://github.com/AnaSL-WRK/IES_104063.git  
>git add .gitignore  
>git commit  
>git push
>```
<br>

## Colaboration simulation:
    
In this case we are creating a folder outside our repo, acting as if we are a collaborator on a different computer, and then merging to our project

```
git clone https://github.com/AnaSL-WRK/IES_104063.git	#in the directory you want to work on
git add							#add your files
git commit 
git push
```
<br>

#### Other option you have is to create a **branch** where you want to work on:

```
cd repo directory or pull repo
git branch coolbranch       	#creating the branch
git checkout future-plans  	#switching to the branch
git add
git commit 
git push
```
<br>

Now your changes exist in the project timeline, but on yet on the project itself  
For that we are going to merge them:

```
git checkout main 		#or master, depending on the version youre using
git merge future-plans 		#your project is now all updated!
git branch -d future-plans 	#delete the branch since you won't use it anymore
```

<br>

### Useful commands:
```git status```		displays the state of the working directory and the staging area (also what branch you're on)  
```git reset HEAD <YOUR-FILE>```to unstage a file (be sure to also write the file extension)  
```git reset HEAD . ```		to unstage all files   


### Errors that happened:

```error: failed to push some refs to 'https://github.com/AnaSL-WRK/IES_104063.git'```  
<br>
- **solution:** ```git pull --rebase origin main```
- gets the files from remote repo to local, then just add the project again
<br>

<code> error: 'weatherApp' does not have a commit checked out 
	fatal: adding files failed</code>
	
- **cause:** created a .git  in a subfolder  
- **solution:** delete the .git folder (may have to activate 'view hidden folders')  
```git status```   #if you want to check the files 'deleted'  
```git restore . ```
