# react-native-archiver
An archiving utility library for working with multiple archiving formats

## Getting started

`$ npm install react-native-archiver --save`

### Mostly automatic installation

`$ react-native link react-native-archiver`

### Manual installation


#### iOS
## Not supported yet
1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-archiver` and add `RNArchiver.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNArchiver.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.rnarchiver.RNArchiverPackage;` to the imports at the top of the file
  - Add `new RNArchiverPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-archiver'
  	project(':react-native-archiver').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-archiver/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-archiver')
  	```


## Usage
```javascript
import RNArchiver from 'react-native-archiver';

// TODO: What to do with the module?
RNArchiver.untar(archivePath, destinationPath);
```
  