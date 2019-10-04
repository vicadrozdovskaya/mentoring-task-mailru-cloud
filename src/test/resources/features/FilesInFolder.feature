Feature: FilesInFolder

 Background:
    Given I opened Yendex Disk site

  Scenario Outline: Searching file item in Folder
    When I open Folder page <nameFolder>
    And I search <fileItem>
    Then File Item name equals $<name>


    Examples:
          | fileItem                            | name         |nameFolder|
          | L&D ATM8 - Hometask M10 - Java.docx | L&D ATM8 - Hometask M10 - Java.docx   | Text|