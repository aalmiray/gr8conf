package addressbook

application(title: 'addressbook',
  pack: true,
  resizable: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    menuBar {
        menu(getMessage('title.Contacts', 'Contacts')) {
            menuItem(newAction)
            menuItem(saveAction)
            menuItem(deleteAction)
            menuItem(dumpAction)
        }
    }
    migLayout(layoutConstraints: 'fill')
    scrollPane(constraints: 'west, w 180!') {
        list()
    }
    panel(constraints: 'center, grow', border: titledBorder(title: getMessage('title.Contact', 'Contact'))) {
        migLayout(layoutConstraints: 'fill')
        for (propName in Contact.PROPERTIES) {
            String key = "addressbook.Contact.${propName}.label"
            label(text: getMessage(key, GriffonNameUtils.getNaturalName(propName)) + ':', constraints: 'right')
            textField(columns: 30, constraints: 'grow, wrap',
                text: bind(propName, source: model, mutual: true))
        }
    }
    panel(constraints: 'east, grow', border: titledBorder(title: getMessage('title.Actions', 'Actions'))) {
        migLayout()
        button(newAction,    constraints: 'growx, wrap')
        button(saveAction,   constraints: 'growx, wrap')
        button(deleteAction, constraints: 'growx, wrap')
        button(dumpAction,   constraints: 'growx, wrap')
    }
}
