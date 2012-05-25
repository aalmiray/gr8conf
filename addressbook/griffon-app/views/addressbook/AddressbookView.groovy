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
        menu('Contacts') {
            menuItem('New',    actionPerformed: controller.newAction)
            menuItem('Save',   actionPerformed: controller.saveAction)
            menuItem('Delete', actionPerformed: controller.deleteAction)
            menuItem('Dump',   actionPerformed: controller.&dumpAction)
        }
    }
    migLayout(layoutConstraints: 'fill')
    scrollPane(constraints: 'west') {
        list()
    }
    panel(constraints: 'center, grow', border: titledBorder(title: 'Contact')) {
        label('content')
    }
    panel(constraints: 'east, grow', border: titledBorder(title: 'Actions')) {
        migLayout()
        button('New',    actionPerformed: controller.newAction,    constraints: 'growx, wrap')
        button('Save',   actionPerformed: controller.saveAction,   constraints: 'growx, wrap')
        button('Delete', actionPerformed: controller.deleteAction, constraints: 'growx, wrap')
        button('Dump',   actionPerformed: controller.&dumpAction,  constraints: 'growx, wrap')
    }
}
