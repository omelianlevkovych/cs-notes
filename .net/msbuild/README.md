# msbuild
## Basics
Project files (csproj) are actually msbuild files.  
There are two styles: Legacy and SDK-style of proj files.  

The biggest simplification ever (what is msbuild):
```sh
public class Project
{
    public Dictionary<string, string> Properties {get; set;}
    public Dictionary<string, Dictionary<string, string>> Items {get; set;}
}
```

https://www.youtube.com/watch?v=5HEbsyU5E1g

